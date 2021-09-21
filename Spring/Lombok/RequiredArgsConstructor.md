# @RequiredArgsConstructor

> @RequiredArgsConstructor generates a constructor with 1 parameter for each field that requires special handling. All non-initialized final fields get a parameter, as well as any fileds that are marked as @NonNull that aren't initialized where they are declared. 
>
> For those fields marked with `@NonNull`, an explicit null check is also generated. The constructor will throw a `NullPointerException` if any of the parameters intended for the fields marked with `@NonNull` contain `null`. The order of the parameters match the order in which the fields appear in your class.

###  | Reference 

###### https://projectlombok.org/features/constructor 
