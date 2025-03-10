import java.util.List;

public interface UserRepository extends Repository<Integer,User> {
    List<User> findByName(String manufacturer);
    List<User> findBetweenHeight(int min, int max);
}
