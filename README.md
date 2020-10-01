
"# product-ms2" 
docker build -t mohdtabish999/product-ms2:1.0 . <br/>
docker run -p 8081:8081 mohdtabish999/product-ms2<br/>
docker exec -it <containerid> sh <br/>
go to browser https://localhost:8081

In openshift change service target port 
OR
change pod, deployment, service, router object port in yaml 
