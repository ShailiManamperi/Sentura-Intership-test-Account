package lk.ijse.test.Dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uid;
    private String display_name;
    private String email;
    private String given_name;
    private String middle_name;
    private String name;
    private String family_name;
    private String nickname;
    private String phone_number;
    private String comment;
    private int directory_id;
    private int picture_id;
    private String avatar_url;
    private Object metadata;
    private String[] tags;
    private String presence;
    private String created_at;
    private String modified_at;
    private boolean is_suspended;
    private boolean is_trashed;


}
