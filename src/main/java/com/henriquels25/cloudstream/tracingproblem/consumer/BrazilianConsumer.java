package com.henriquels25.cloudstream.tracingproblem.consumer;

import com.henriquels25.cloudstream.tracingproblem.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component("br")
@Slf4j
class BrazilianConsumer implements Function<Person, Message<Person>> {
    @Override
    public Message<Person> apply(Person person) {
        log.info("Receiving a brazilian: {}", person);

        return MessageBuilder.withPayload(person)
                .setHeader("spring.cloud.stream.sendto.destination",
                        "brazilians-out-0")
                .build();
    }

}
