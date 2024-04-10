WITH roles_data AS (SELECT 'USER'            AS name,
                           1                 as version,
                           current_timestamp as created_at,
                           current_timestamp as last_modified_at
                    UNION ALL
                    SELECT 'ADMIN'           AS name,
                           1                 as version,
                           current_timestamp as created_at,
                           current_timestamp as last_modified_at)


INSERT
INTO role (name, version, created_at, last_modified_at)
SELECT *
FROM roles_data
WHERE NOT EXISTS (SELECT *
                  FROM role);

