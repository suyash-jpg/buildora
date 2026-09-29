package com.projects.buildora.entity;
import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class User {
      Long id;

    @Column(unique = true)
     String email;

     String passwordHash;

     String name;

     String avatar_url;

     Instant createdAt;

     Instant updatedAt;

     Instant deletedAt;
}
