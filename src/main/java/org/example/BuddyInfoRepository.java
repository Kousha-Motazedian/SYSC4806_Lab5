package org.example;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long>{
    public BuddyInfo findById(long id);
    public List<BuddyInfo> findByAddress(String address);
    public List<BuddyInfo> findByName(String name);
    public BuddyInfo findByPhoneNumber(String number);
}
