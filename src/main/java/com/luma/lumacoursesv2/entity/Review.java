package com.luma.lumacoursesv2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(
        name = "reviews",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_reviews_course_student",
                        columnNames = {"course_id", "student_id"}
                )
        }

)
public class Review {



        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "review_id")
        private Long id;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "course_id", nullable = false)
        private Course course;

        @NotNull
        @ManyToOne
        @JoinColumn(name = "student_id", nullable = false)
        private User student;

        @Min(1)
        @Max(5)
        @Column(name = "rating", nullable = false)
        private int rating;

        @Column(name = "comment", columnDefinition = "text")
        private String comment;

        @CreationTimestamp
        @Column(name = "created_at", nullable = false, updatable = false)
        private LocalDateTime createdAt;

        @UpdateTimestamp
        @Column(name = "updated_at", nullable = false)
        private LocalDateTime updatedAt;



}
