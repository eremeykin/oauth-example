#!/bin/bash
# initial request
form=$(curl -vL -X GET -u alice:alice123 -c cookie1.tmp -L "http://localhost:10081/recommendation")
echo $form
action=$(echo "$form" | egrep -o "action=\".*\"" | cut -d "\"" -f2 | sed 's/&amp;/\&/g')

# submit keycloak form
redirect=$(curl -v -X POST -i -b cookie1.tmp -c cookie2.tmp "$action" \
  -H "Content-Type: application/x-www-form-urlencoded" -d "username=alice&password=alice&credentialId=")
echo $redirect
redirect=$(echo -n "$redirect" | grep "Location:" | cut -d " " -f2 | tr -d '\n' | tr -d '\r')

# get resource
final=$(curl -X GET -u alice:alice123 -L -v -b cookie2.tmp $redirect)
echo $final
