FROM postgres:9.4.9

VOLUME /var/lib/postgresql/data

COPY ["setup.sh", "/docker-entrypoint-initdb.d/"]

EXPOSE 5432
