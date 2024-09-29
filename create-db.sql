--create database telemetry_mgr;
--create database device_mgr;

SELECT 'CREATE DATABASE telemetry_mgr'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'telemetry_mgr')\gexec

SELECT 'CREATE DATABASE device_mgr'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'device_mgr')\gexec