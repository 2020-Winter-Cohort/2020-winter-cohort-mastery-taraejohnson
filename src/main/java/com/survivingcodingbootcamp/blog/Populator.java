package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    @Autowired
    HashtagStorage hashtagStorage;
    @Autowired
    PostStorage postStorage;
    @Autowired
    TopicStorage topicStorage;

    @Override
    public void run(String... args) throws Exception {

        Topic topic1 = new Topic("Learning TDD");
        topicStorage.save(topic1);

        Post post1 = new Post("TDD For Fun and Profit", "Silvia Federici", topic1, "The revival of magical beliefs is possible today because it no longer represents a social threat. The mechanization of the body is so constitutive of the individual that, at least in industrialized countries, giving space to the belief in occult forces does not jeopardize the regularity of social behavior. Astrology too can be allowed to return, with the certainty that even the most devoted consumer of astral charts will automatically consult the watch before going to work.");
        postStorage.save(post1);

        Post post2 = new Post("Test the Fear Away", "Gilles Deleuze", topic1, "The technocrat is the natural friend of the dictator—computers and dictatorship; but the revolutionary lives in the gap which separates technical progress from social totality, and inscribed there his dream of permanent revolution. This dream, therefore, is itself action, reality, and an effective menace to all established order; it renders possible what it dreams about.");
        postStorage.save(post2);

        Post post3 = new Post("Unit Tests and You", "Simone Weil", topic1, "When we hit a nail with a hammer, the whole of the shock received by the large head of the nail passes into the point without any of it being lost, although it is only a point. If the hammer and the head of the nail were infinitely big it would be just the same. The point of the nail would transmit this infinite shock at the point to which it was applied. Extreme affliction, which means physical pain, distress of soul and social degradation, all at the same time, constitutes the nail. The point is applied at the very center of the soul, whose head is all necessity, spreading throughout space and time.");
        postStorage.save(post3);

        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicStorage.save(topic2);
        Topic topic3 = new Topic("Introductory Java");
        topicStorage.save(topic3);
        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicStorage.save(topic4);

    }

}
