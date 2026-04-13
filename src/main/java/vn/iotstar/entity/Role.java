package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "users")
@ToString(exclude = "users")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleID;

    @Column(name = "RoleName", columnDefinition = "nvarchar(255)")
    private String roleName;

    // Mối quan hệ 1:N với User
    @OneToMany(mappedBy = "role")  // mappedBy trỏ đến thuộc tính "role" trong lớp User
    private List<User> users;

}
