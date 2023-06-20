docker volume create pgdata
docker run --rm --name creatorcorner-db -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=creatorcorner -d -p 5433:5432 -v pgdata:/var/lib/postgresql postgres:latest
