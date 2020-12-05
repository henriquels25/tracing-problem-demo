package com.henriquels25.cloudstream.tracingproblem.consumer;

import com.henriquels25.cloudstream.tracingproblem.dto.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component("us")
@Slf4j
@AllArgsConstructor
class AmericanConsumer implements Consumer<Person> {

    private final BinderAwareChannelResolver resolver;

    @Override
    public void accept(Person person) {
        log.info("Receiving an american: {}", person);

        resolver.resolveDestination("americans-out-0")
                .send(MessageBuilder.withPayload(person).build());
    }
}
