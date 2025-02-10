from cassandra.cluster import Cluster
from cassandra.auth import PlainTextAuthProvider
from ssl import SSLContext, PROTOCOL_TLS, CERT_REQUIRED

import random
import time

### Connect to the ScyllaDB cluster
contact_points = ['172.19.0.2']  # Replace with your actual service name or IPs


### Create a cluster instance with RBAC only
#username = 'your_username' # if using rbac
#password = 'your_password' # if using rbac
#auth_provider = PlainTextAuthProvider(username, password)
#cluster = Cluster(contact_points, auth_provider=auth_provider)


# connect to cluster
cluster = Cluster(contact_points)
session = cluster.connect()


# Create a Keyspace

session.execute(
    """
    CREATE KEYSPACE IF NOT EXISTS ivan_cdc_ks
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}
    AND durable_writes = true;
    """)


# Create table

session.execute(
    """
    CREATE TABLE IF NOT EXISTS ivan_cdc_ks.ivan_cdc_table (
    sensor_id text,
    coordinate int,
    status text,
    PRIMARY KEY(sensor_id, coordinate))
    WITH cdc = {'enabled': true};
    """)


# Set keyspace and execute a SELECT query
session.set_keyspace('system')
rows = session.execute('SELECT * FROM roles')

# Print results
for row in rows:
    print(row)



#### Set KEYSPACE and execute an INSERT QUERY

# Set Keyspace
session.set_keyspace('ivan_cdc_ks')

# Truncate Table
truncate_query = "TRUNCATE ivan_cdc_table"
session.execute(truncate_query);

###
iter = 10000
sensor_id = []
random_integer = random.randint(1, iter)

for i in range(iter):
    # Prepare the INSERT statement
    query="INSERT INTO ivan_cdc_table (sensor_id, coordinate, status) VALUES (?, ?, ?)"
    prepstmt = session.prepare(query)
    session.execute_async(prepstmt,('sensor'+str(i), i, 'ACTIVE' ))
    time.sleep(0.05) # Delay for 0.05 seconds

print("Code Executed")
