
---

## ✅ 1. `@Component`

* Used to **mark a class as a Spring-managed bean**.
* When Spring starts, it scans the classpath and creates objects (beans) for classes annotated with `@Component`.

### Example:

```java
public interface Computer {
    void compile();
}

@Component
public class Desktop implements Computer {
    public void compile() {
        System.out.println("Compiling on Desktop");
    }
}

@Component
public class Laptop implements Computer {
    public void compile() {
        System.out.println("Compiling on Laptop");
    }
}
```

---

## ✅ 2. `@Autowired`

* Tells Spring to **automatically inject the dependency**.
* It can be used on **constructors**, **fields**, or **setters**.

### Example:

```java
@Component
public class Developer {

    @Autowired
    private Computer computer;

    public void buildProject() {
        computer.compile();
    }
}
```

❗**Problem:** Spring doesn't know whether to inject `Desktop` or `Laptop` since both are `@Component`s implementing `Computer`.

---

## ✅ 3. `@Primary`

* Tells Spring to use this bean **by default** when multiple candidates are present.

### Example:

```java
@Primary
@Component
public class Desktop implements Computer {
    public void compile() {
        System.out.println("Compiling on Desktop");
    }
}
```

Now Spring will inject `Desktop` automatically if no `@Qualifier` is used.

---

## ✅ 4. `@Qualifier`

* Used to specify **which bean to inject** when multiple candidates are available.

### Example:

```java
@Component
public class Laptop implements Computer {
    public void compile() {
        System.out.println("Compiling on Laptop");
    }
}

@Component
public class Developer {

    @Autowired
    @Qualifier("laptop")
    private Computer computer;

    public void buildProject() {
        computer.compile();
    }
}
```

---

## 🔁 Summary Table

| Annotation   | Purpose                                                |
| ------------ | ------------------------------------------------------ |
| `@Component` | Marks a class to be registered as a Spring bean        |
| `@Autowired` | Injects a dependency automatically                     |
| `@Primary`   | Sets a default bean to be injected when multiple exist |
| `@Qualifier` | Specifies exactly which bean to inject                 |

---