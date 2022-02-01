package ru.tuzov.restchooser.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "restaurant_unique_name_idx"))
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Restaurant extends BaseEntity {

    @Size(min = 2, max = 127)
    @NotBlank
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 255)
    @NotBlank
    @NotBlank
    @Column(name = "address")
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Choose> chooses;

    @JsonManagedReference
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Meal> menu;
}
