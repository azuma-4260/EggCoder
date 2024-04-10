FROM --platform=linux/x86_64 mysql:8.0

COPY initdb.d/sql/common /docker-entrypoint-initdb.d/
COPY initdb.d/sql/app /docker-entrypoint-initdb.d/
