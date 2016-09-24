Spark
=====
docker network create --label spark-network-label --gateway 172.22.0.1 --subnet 172.22.0.0/24 spark-network
docker run --rm -it -p 4040:4040 -p 7077:7077 --net=spark-network --ip 172.22.0.2 --name=spark gettyimages/spark bash
./sbin/start-master.sh