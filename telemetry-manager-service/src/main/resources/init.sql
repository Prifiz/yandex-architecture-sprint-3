CREATE TABLE IF NOT EXISTS telemetry (
    id BIGSERIAL PRIMARY KEY,
    device_id BIGSERIAL NOT NULL,
    telemetry_unit VARCHAR NOT NULL,
    data VARCHAR NOT NULL,
    produced_at TIMESTAMP NOT NULL
);