package com.piyush.task;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.CodecRegistry;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.TypeCodec;
import com.datastax.driver.extras.codecs.arrays.DoubleArrayCodec;
import com.datastax.driver.extras.codecs.arrays.FloatArrayCodec;
import com.datastax.driver.extras.codecs.arrays.IntArrayCodec;
import com.datastax.driver.extras.codecs.arrays.LongArrayCodec;
import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import com.datastax.driver.extras.codecs.jdk8.InstantCodec;
import com.datastax.driver.extras.codecs.joda.LocalDateCodec;
import com.datastax.driver.extras.codecs.joda.LocalTimeCodec;
import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

/**
 * Created by piyush on 4/11/16.
 */

@Repository
public class CassandraService {

  /**
   * Cassandra Session.
   */
  private Session session;

  public CassandraService(@Value("${cassandra.address:127.0.0.1}") String address,
                          @Value("${cassandra.port:9042}") int port) {

    CodecRegistry codecRegistry = CodecRegistry.DEFAULT_INSTANCE

        .register(com.datastax.driver.extras.codecs.joda.InstantCodec.instance)
        .register(com.datastax.driver.extras.codecs.joda.InstantCodec.instance)
        .register(LocalDateCodec.instance)
        .register(LocalDateCodec.instance)
        .register(LocalTimeCodec.instance)
        .register(LocalTimeCodec.instance)
        .register(DoubleArrayCodec.instance)
        .register(FloatArrayCodec.instance)
        .register(IntArrayCodec.instance)
        .register(InstantCodec.instance)
        .register(TypeCodec.cint())
        .register(new EnumNameCodec<>(Status.class))
        .register(TypeCodec.bigint())
        .register(TypeCodec.PrimitiveIntCodec.cint())
        .register(LongArrayCodec.instance);

    Cluster cluster = Cluster.builder()
        .addContactPoint(address)
        .withPort(port)
        .withCodecRegistry(codecRegistry)
        .build();

    session = cluster.connect();
  }

  <T> Mapper<T> mapper(Class<T> t) {
    MappingManager manager = new MappingManager(session);
    return manager.mapper(t);
  }

  <T> T accessor(Class<T> t) {
    MappingManager manager = new MappingManager(session);
    return manager.createAccessor(t);
  }

}
