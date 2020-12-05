package com.henriquels25.cloudstream.tracingproblem.consumer;

import com.henriquels25.cloudstream.tracingproblem.dto.Person;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component("de")
@Slf4j
@AllArgsConstructor
class GermanConsumer implements Consumer<Person> {

    private final StreamBridge streamBridge;

    @Override
    public void accept(Person person) {
        log.info("Receiving a german: {}", person);

        streamBridge.send("germans-out-0", person);
    }

}
