package ru.tuzov.restchooser.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "user_choose", uniqueConstraints = @UniqueConstraint(name = "one_choose_per_day_idx", columnNames = {"user_id", "date_of_choose"}))
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Choose extends BaseEntity {

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "date_of_choose", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE()")
    private LocalDate dateOfChoose;

    @Column(name = "time_of_vote", nullable = false, columnDefinition = "TIME DEFAULT CURRENT_TIME()")
    private LocalTime timeOfChoose;

    public Choose(User user, Restaurant restaurant, LocalDate dateOfChoose, LocalTime timeOfChoose) {
        this.user = user;
        this.restaurant = restaurant;
        this.dateOfChoose = dateOfChoose;
        this.timeOfChoose = timeOfChoose;
    }
}
