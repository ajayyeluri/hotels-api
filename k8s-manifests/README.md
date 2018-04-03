# Installation 

Congrats now you are ready to run your services 

## Deploy your services 

```

kubectl create -f deploy.yml 

# to redeploy 

kubectl delete -f deploy.yml 
kubectl create -f deploy.yml 


```

That should be all.. Lets check if our app are running 

```

kubectl get pods -o=wide 

# you should see the below 
# This means that you have 1 instance of your service running
 
NAME                                        READY     STATUS              RESTARTS   AGE       IP          NODE
integration-api-656f8b699b-pbvqz                  1/1       Running             0          4m        10.8.2.10   gke-cluster-1-default-pool-6b34ab77-lb5g
```

Now Lets expose it 

```

kubectl create -f service.yml 

# to recreate 

kubectl delete -f service.yml 
kubectl create -f service.yml 


```

That should be all . The Service is running 

```

kubectl get services -o=wide

# Result 

NAME            TYPE           CLUSTER-IP      EXTERNAL-IP     PORT(S)                      AGE       SELECTOR
integration-api       LoadBalancer   10.11.255.249   35.224.214.58   8090:30294/TCP               41m       app=integration-api

```

Your app integration-api is now exposed on externally on EXTERNAL-IP:PORT 

Lets load and query some data ....

```

curl -X POST 35.224.214.58:8090/v1/contacts/load

# now lets see what we loaded 

curl 35.224.214.58:8090/v1/contacts

```

You should see the below 

```
{"content":[
{"id":1,"name":"name - 10000","email":"email@10000","city":"City - 10000","zipcode":0},
{"id":2,"name":"name - 10001","email":"email@10001","city":"City - 10001","zipcode":1},
{"id":3,"name":"name - 10002","email":"email@10002","city":"City - 10002","zipcode":2},
{"id":4,"name":"name - 10003","email":"email@10003","city":"City - 10003","zipcode":3},
{"id":5,"name":"name - 10004","email":"email@10004","city":"City - 10004","zipcode":4},
{"id":6,"name":"name - 10005","email":"email@10005","city":"City - 10005","zipcode":0},
{"id":7,"name":"name - 10006","email":"email@10006","city":"City - 10006","zipcode":1},
{"id":8,"name":"name - 10007","email":"email@10007","city":"City - 10007","zipcode":2},
{"id":9,"name":"name - 10008","email":"email@10008","city":"City - 10008","zipcode":3},
{"id":10,"name":"name - 10009","email":"email@10009","city":"City - 10009","zipcode":4}],
"last":true,"totalElements":10,"totalPages":1,"first":true,"sort":null,"numberOfElements":10,"size":100,"number":0}

```
