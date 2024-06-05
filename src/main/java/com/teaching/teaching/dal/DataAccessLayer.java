package com.teaching.teaching.dal;

import com.teaching.teaching.models.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Getter
public class DataAccessLayer {
    private final SessionFactory sessionFactory;

    @Autowired
    public DataAccessLayer(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    Session session = null;


    public void createMaterial(Material newMaterial) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newMaterial);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteMaterialById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Material material = session.get(Material.class, id);
        session.remove(material);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Material getMaterialById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Material material = session.get(Material.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return material;
    }
    public List<Material> getMaterials(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Material> query = builder.createQuery(Material.class);
        Root<Material> root = query.from(Material.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateMaterialById(Long id, Material updatedMaterial){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Material material = session.get(Material.class, id);
        material.setDescription(updatedMaterial.getDescription());
        material.setPrice(updatedMaterial.getPrice());
        material.setAvailability(updatedMaterial.isAvailability());
        material.setLanguage(updatedMaterial.getLanguage());
        material.setKnowledgeLevel(updatedMaterial.getKnowledgeLevel());
        session.merge(material);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public List<Material> getMaterialByKnowledgeLevelId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Material> query = builder.createQuery(Material.class);
        Root<Material> root = query.from(Material.class);
        Predicate knowledgeLevelIdPredicate = builder.equal(root.get("knowledgeLevel").get("knowledgeLevelId"), id);
        query.select(root).where(knowledgeLevelIdPredicate);
        return session.createQuery(query).getResultList();
    }
    public List<Material> getMaterialByLanguageId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Material> query = builder.createQuery(Material.class);
        Root<Material> root = query.from(Material.class);
        Predicate languageIdPredicate = builder.equal(root.get("language").get("languageId"), id);
        query.select(root).where(languageIdPredicate);
        return session.createQuery(query).getResultList();
    }
    //Проверить
//    public List<Material> getMaterialByDescription(String description) {
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Material> query = builder.createQuery(Material.class);
//        Root<Material> root = query.from(Material.class);
//        Predicate descriptionPredicate = builder.like(builder.lower(root.get("description")), "%" + description.toLowerCase() + "%");
//        Predicate searchPredicate = builder.or(descriptionPredicate);
//        query.select(root).where(searchPredicate);
//        return session.createQuery(query).getResultList();
//    }
//    public List<Material> getMaterialByPrice(Long price) {
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Material> query = builder.createQuery(Material.class);
//        Root<Material> root = query.from(Material.class);
//        Predicate descriptionPredicate = builder.like(builder.lower(root.get("price")), "%" + price + "%");
//        Predicate searchPredicate = builder.or(descriptionPredicate);
//        query.select(root).where(searchPredicate);
//        return session.createQuery(query).getResultList();
//    }
    //Boolean. Исправить
//    public List<Material> getMaterialByAvailability(Boolean availability) {
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<Material> query = builder.createQuery(Material.class);
//        Root<Material> root = query.from(Material.class);
//        Predicate descriptionPredicate = builder.like(builder.lower(root.get("availability")), "%" + availability + "%");
//        Predicate searchPredicate = builder.or(descriptionPredicate);
//        query.select(root).where(searchPredicate);
//        return session.createQuery(query).getResultList();
//    }











    public void createBill(Bill newBill) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newBill);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteBillById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Bill bill = session.get(Bill.class, id);
        session.remove(bill);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Bill getBillById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Bill bill = session.get(Bill.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return bill;
    }
    public List<Bill> getBills(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
        Root<Bill> root = query.from(Bill.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateBillById(Long id, Bill updatedBill){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Bill bill = session.get(Bill.class, id);
        bill.setUser(updatedBill.getUser());
        bill.setEmployee(updatedBill.getEmployee());
        bill.setMaterial(updatedBill.getMaterial());
        session.merge(bill);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public List<Bill> getBillByEmployeeId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
        Root<Bill> root = query.from(Bill.class);
        Predicate employeeIdPredicate = builder.equal(root.get("employee").get("employeeId"), id);
        query.select(root).where(employeeIdPredicate);
        return session.createQuery(query).getResultList();
    }
    public List<Bill> getBillByCustomerId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
        Root<Bill> root = query.from(Bill.class);
        Predicate customerIdPredicate = builder.equal(root.get("customer").get("customerId"), id);
        query.select(root).where(customerIdPredicate);
        return session.createQuery(query).getResultList();
    }
    public List<Bill> getBillByMaterialId(Long id) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Bill> query = builder.createQuery(Bill.class);
        Root<Bill> root = query.from(Bill.class);
        Predicate materialIdPredicate = builder.equal(root.get("material").get("materialId"), id);
        query.select(root).where(materialIdPredicate);
        return session.createQuery(query).getResultList();
    }






    public void createEmployee(Employee newEmployee) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newEmployee);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteEmployeeById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.remove(employee);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Employee getEmployeeById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return employee;
    }
    public List<Employee> getEmployees(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateEmployeeById(Long id, Employee updatedEmployee){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        employee.setFullName(updatedEmployee.getFullName());
        employee.setEmployeeCategory(updatedEmployee.getEmployeeCategory());
        session.merge(employee);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }




    public void createEmployeeCategory(EmployeeCategory newEmployeeCategory) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newEmployeeCategory);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteEmployeeCategoryById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeCategory employeeCategory = session.get(EmployeeCategory.class, id);
        session.remove(employeeCategory);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public EmployeeCategory getEmployeeCategoryById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeCategory employeeCategory = session.get(EmployeeCategory.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return employeeCategory;
    }
    public List<EmployeeCategory> getEmployeeCategories(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<EmployeeCategory> query = builder.createQuery(EmployeeCategory.class);
        Root<EmployeeCategory> root = query.from(EmployeeCategory.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateEmployeeCategoryById(Long id, EmployeeCategory updatedEmployeeCategory){
        session = sessionFactory.openSession();
        session.beginTransaction();
        EmployeeCategory employeeCategory = session.get(EmployeeCategory.class, id);
        employeeCategory.setEmployeeCategoryName(updatedEmployeeCategory.getEmployeeCategoryName());
        session.merge(employeeCategory);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }



    public void createKnowledgeLevel(KnowledgeLevel newKnowledgeLevel) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newKnowledgeLevel);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteKnowledgeLevelById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        KnowledgeLevel knowledgeLevel = session.get(KnowledgeLevel.class, id);
        session.remove(knowledgeLevel);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public KnowledgeLevel getKnowledgeLevelById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        KnowledgeLevel knowledgeLevel = session.get(KnowledgeLevel.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return knowledgeLevel;
    }
    public List<KnowledgeLevel> getKnowledgeLevels(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<KnowledgeLevel> query = builder.createQuery(KnowledgeLevel.class);
        Root<KnowledgeLevel> root = query.from(KnowledgeLevel.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateKnowledgeLevelById(Long id, KnowledgeLevel updatedKnowledgeLevel){
        session = sessionFactory.openSession();
        session.beginTransaction();
        KnowledgeLevel knowledgeLevel = session.get(KnowledgeLevel.class, id);
        knowledgeLevel.setKnowledgeLevelName(updatedKnowledgeLevel.getKnowledgeLevelName());
        session.merge(knowledgeLevel);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }



    public void createLanguage(Language newLanguage) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(newLanguage);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public void deleteLanguageById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Language language = session.get(Language.class, id);
        session.remove(language);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }
    public Language getLanguageById(Long id){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Language language = session.get(Language.class, id);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
        return language;
    }
    public List<Language> getLanguages(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Language> query = builder.createQuery(Language.class);
        Root<Language> root = query.from(Language.class);
        query.select(root);
        return session.createQuery(query).getResultList();
    }
    public void updateLanguageById(Long id, Language updatedLanguage){
        session = sessionFactory.openSession();
        session.beginTransaction();
        Language language = session.get(Language.class, id);
        language.setLanguageName(updatedLanguage.getLanguageName());
        session.merge(language);
        session.getTransaction().commit();
        if (session != null) {
            session.close();
        }
    }





    public String newUserToDatabase(User user) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        String name = user.getUserName();

        // Check if the username is empty
        if (name == null || name.trim().isEmpty()) {
            return "Имя пользователя не может быть пустым";
        }

        Query query = session
                .createQuery("FROM User where userName = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();

        if (userFrom != null) {
            return "Выберите другое имя";
        }
        String hashedPassword = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
        user.setPassword(hashedPassword);
        user.setRole("user");

        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return "Good work";
    }
    public User getUserFromDatabaseByUsername(String name){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Query query = session
                .createQuery("FROM User where userName = :username")
                .setParameter("username", name);
        User userFrom = (User) query.uniqueResult();
        if (userFrom == null) {
            return null;
        }
        return userFrom;
    }
    public User getUserId(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
        return user;
    }
    public List<User> getUsers(){
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.select(root);
        List<User> resultList = session.createQuery(query).getResultList();
        return resultList;
    }
    public  void updateUser(Long id, User updateUser){
        session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        user.setUserId(updateUser.getUserId());
        user.setUserAge(updateUser.getUserAge());
        user.setUserName(updateUser.getUserName());
        user.setRole(updateUser.getRole());
        user.setPassword(updateUser.getPassword());
        session.merge(user);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }
    public void delUserById(Long id){
        session=sessionFactory.openSession();
        session.beginTransaction();
        User user=session.get(User.class,id);
        session.remove(user);
        session.getTransaction().commit();
        if(session!=null){
            session.close();
        }
    }

}
