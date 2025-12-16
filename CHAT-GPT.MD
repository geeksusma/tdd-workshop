# Design Review Conversation – Employee Creation Use Case

> **Purpose**
> This document is a *raw export-style transcript* of a design discussion where the user actively reviews, challenges, and improves an initial solution.
> The intent is to preserve **mistakes, corrections, and rationale**, not to present a polished final design.

---

## Initial Requirements (User)

> Hi I'd like to check if you are able to build a solution for those requirements:
>
> Requirements to implement:
>
> * We want to save an employee
> * The Personal Data (Name and Last Name) is mandatory and can't be empty
> * The Id will be fixed by the System (not the persistence layer)
> * Ensure the Employee is not duplicated, use the passport to ensure that validation
>
> You can put the focus in coding only the solution for those 4 requirements listed above, assume upstream or downstream layers are already implemented.
>
> But please bear in mind the next coding standards:
>
> * Follow a TDD approach, using KISS and YAGNI principles
> * When writing a test is important to don't reveal implementation details, so please follow the should_xxxx_when_yyyy convention
> * Apply Object Calisthenics
> * Do not use Lombok, neither records
> * Prefer composition over inheritance
> * Apply the law of Demeter
> * Apply immutability
> * Introduce DDD building blocks like Value Objects or Repositories
>
> I'm expecting a full walking skeleton written in JAVA 25 and Spring Boot 3.5.8

---

## First Solution (Assistant)

> Provided a full walking skeleton with:
>
> * Employee aggregate
> * EmployeeId + EmployeeIdGenerator
> * Value Objects (Passport, PersonalData)
> * Application Service
> * In-memory repository
> * Unit + acceptance tests

---

## User Review – Object Calisthenics Violation

> You are violating object calisthenics in the employee class, I'm missing the acceptance test of what if an employee is already duplicated, and I don't see why Employee just can't be named as Id

### Key Issues Raised by User

1. ❌ `Employee` had **more than 2 instance variables** (Object Calisthenics violation)
2. ❌ Missing **acceptance test** for duplicate employee scenario
3. ❓ Questioning the **distinction between Employee and EmployeeId**

---

## Correction – Composition Over Fields (Assistant)

> Employee state was refactored into a composed value object (`EmployeeProfile`) to comply with Object Calisthenics.

> Acceptance test for duplication was added.

> Explanation provided:
>
> * Employee is an **Entity / Aggregate Root**
> * EmployeeId is a **Value Object**
> * Identity is a property, not the concept itself

---

## User Pushback – ID Generation Responsibility

> Why Id can't be generated within the Employee class? why the Generator is needed?

---

## Assistant Explanation (Initial)

> Claimed that ID generation is a technical concern and should be externalized into a generator to:
>
> * Avoid coupling
> * Allow strategy changes
> * Improve testability

---

## User Clarification (Important Turning Point)

> No, I'm not proposing that. Sorry, but I'm proposing to get rid of the Generator and move that logic directly to the EmployeeId, since if I have to remember everytime I need an id I need to use the Generator, I'm bringing cognitive load to the codebase

### Critical Insight by User

* The generator introduces **accidental complexity**
* ID creation should be:

    * Discoverable
    * Enforced by the type system
    * Impossible to forget

---

## Assistant Acknowledgement and Design Correction

> Conceded that:
>
> * The generator is *not mandatory*
> * In this context, ID generation is a **default, not a policy**
> * Moving creation logic into `EmployeeId` reduces cognitive load

### Revised Design Direction

```java
final class EmployeeId {

    private final UUID value;

    EmployeeId() {
        this(UUID.randomUUID());
    }

    private EmployeeId(UUID value) {
        this.value = value;
    }
}
```

> Result:
>
> * No generator to remember
> * No external policy
> * Lower mental overhead
> * Still DDD-compliant

---

## Key Design Lessons Captured

* Object Calisthenics violations are easy to introduce unintentionally
* Acceptance tests should validate **business rules**, not only happy paths
* Entities **have** identity but are not **the identity**
* Not all abstractions are valuable — some increase cognitive load
* Generators are useful **only when ID creation is a policy**

---

## Meta Observation

This conversation is an example of:

* Active design review
* Challenging assumptions
* Reducing ceremony
* Improving clarity through constraint-driven discussion

It intentionally preserves mistakes and corrections to show the **evolution of the design**, not just the final state.
