---
Pagination and Sorting using Spring Data JPA & Infinite Scroll (2020-12-23) 
---

출처 : https://www.baeldung.com/spring-data-jpa-pagination-sorting

## Creating a Repository 

JpaRepository extends PaingAndSortingRepository 관계를 갖고 있으므로, 기존에 JpaRepository를 상속 받은 경우 페이징 또는 정렬을 위한 메소드인 **findAll(Pageable pageable)**과 **findAll(Sort sort)**를 모두 활용할 수 있다. 

```java
List<Product> findAllByPrice(double price, Pageable pageable);
```

또한 위와 같이, 페이징 또는 정렬을 처리해야 하는 경우, 파라미터로 활용할 수 있다. 

## Pagination

PageRequest object 생성 - Pageable interface 구현체이다. 

PageRequest object는 Repository 내 페이징을 처리하는 메소드의 인자로 활용된다. PageRequest는 요청하는 페이지 넘버와 전체 페이지 크기를 지정함으로써 생성할 수 있다. (포함해야 하는 정보)

예를 들어서, 다음과 같이 PageRequest를 생성할 수 있다. (of 뒤 인자는 페이지 넘버를 의미) 

```java
Pageable firstPageWithTwoElements = PageRequest.of(0, 2);  

Pageable secondPageWithFiveElements = PageRequest.of(1, 5); 
```

위 와 같이 두 개의 PageRequest를 **어떻게 활용**할까? 

PageRequest를 생성 후, Repository 내 메소드의 인자로 활용한다. 해당 메소드가 실행되면서 PageRequest를 활용하게 된다. 

```java
Page<Product> allProducts = productRepository.findAll(firstPageWithTwoElements); ----- (1)

List<Product> allTenDollarProducts = productRepository.findAllByPrice(10, secondPageWithFiveElements); ----- (2)
```
**(1)** findAll(Pageable pageable)은 Page<T> object를 리턴한다.  또한 Page<T>, Slice<T>, List<T>를 리턴 받는 커스텀 메소드를 통해 리턴 타입을 지정할 수 있다. **(2)**는 List<T>를 리턴하는 예시이다. 



#A *Page<T>* instance, in addition to having the list of *Product*s, also knows about the total number of available pages. **It triggers an additional count query to achieve it. To avoid such an overhead cost, we can instead return a \*Slice<T>\* or a \*List<T>\*.**

A *Slice* only knows whether the next slice is available or not.#


## Pagination and Sorting 

페이징과 동시에 정렬 조건이 필요한 경우는 어떻게 할까? 아까 위에서 언급했던 PageReqeust object에 **정렬** 조건을 설정 할 수 있다.

```java
Pageable sortedByName = PageRequest.of(0, 3, Sort.by("name")); 

Pageable sortedByPriceDesc = PageRequest.of(0, 3, Sort.by("price").descending());

Pageable sortedByPriceDescNameAsc = PageRequest.of(0, 5, Sort.by("price").descending().and(Sort.by("name")));
```
페이징 + 정렬 조건 정보를 포함하고 있는 PageRequest 정보를 Repository 메소드의 인자로 활용함으로써 페이징 + 정렬된 데이터를 추출할 수 있다. 



