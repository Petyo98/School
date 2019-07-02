package com.example.test123.service;

        import com.example.test123.jpa.Class123;
        import com.example.test123.repository.ClassRepository;
        import com.example.test123.service.ServiseInterfaces.ClassService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;


@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassRepository classRepository;



    @Override
    public List<Class123> findAll() {
        return (List<Class123>) classRepository.findAll();
    }

    @Override
    public void addClass(Class123 grades123) {
        classRepository.save(grades123);
    }

    @Override
    public void editClass(Class123 grades123) {

    }

    @Override
    public void deleteClass(long class123Id) {
        classRepository.deleteById(class123Id);
    }


}
