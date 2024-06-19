package br.com.studies.common.config.avro.deserializer;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

public class CustomAvroDeserializer implements Deserializer<GenericRecord> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public GenericRecord deserialize(String topic, byte[] data) {
        try (ByteArrayInputStream input = new ByteArrayInputStream(data)) {
            DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>();
            GenericRecord record = datumReader.read(null, DecoderFactory.get().binaryDecoder(input, null));
            return record;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao desserializar mensagem Avro", e);
        }
    }

    @Override
    public GenericRecord deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
