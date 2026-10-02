package com.projects.buildora.entity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      Long id;

    @Column(unique = true)
     String email;

     String passwordHash;

     String name;

     String avatar_url;

     @CreationTimestamp
     Instant createdAt;

     @UpdateTimestamp
     Instant updatedAt;

     Instant deletedAt;
}
