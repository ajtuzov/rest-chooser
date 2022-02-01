package ru.tuzov.restchooser.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.util.ProxyUtils;
import ru.tuzov.restchooser.HasId;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Access(AccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public abstract class BaseEntity implements HasId {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return id != null ? id : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || !getClass().equals(ProxyUtils.getUserClass(o))) {
            return false;
        }

        BaseEntity that = (BaseEntity) o;
        return id != null && id.equals(that.id);
    }
}
