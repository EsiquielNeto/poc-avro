package br.com.studies.common.config.avro.serializer;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.Optional;

public class CustomAvroSerializer implements Serializer<GenericRecord> {
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, GenericRecord data) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            if (Optional.ofNullable(data).isPresent()) {
                BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(byteArrayOutputStream, null);
                DatumWriter<GenericRecord> datumWriter = new SpecificDatumWriter<>(data.getSchema());
                datumWriter.write(data, binaryEncoder);
                binaryEncoder.flush();
                return byteArrayOutputStream.toByteArray();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar a mensagem Avro", e);
        }
        return new byte[0];
    }

    @Override
    public byte[] serialize(String topic, Headers headers, GenericRecord data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
