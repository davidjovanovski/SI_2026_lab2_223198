# Давид Јовановски 223198 

## Control Flow Graph

**searchBookByTitle** <br/>
<img width="664" height="844" alt="image" src="https://github.com/user-attachments/assets/92a1c8e4-87f1-45d0-ac05-8ad86926bcfb" />

**borrowBook** <br/>
<img width="660" height="847" alt="image" src="https://github.com/user-attachments/assets/90402600-0840-463f-81bc-40e3d3f4d2be" />


## Цикломатска комплексност
Цикломатската комплексност за методот searchBookByTitle е 2, а резултатот го добив со помош на формулата M=E-N+2P, каде P=1 за секој засебен метод. При замена со вредностите за E и N, формулата изгледа M=10-10+2*1=2. <br/>
Цикломатската комплексност за методот borrowBook е исто така 2, а резултатот е добиен на ист начин како и за методот searchBookByTitle.


## Тест случаи според критериумот Every statement
| | test 1 | test 2 | test 3 |
|---|---|---|---|
| line 1 | * | * | * |
| line 2 | * | | |
| line 3 | | * | * |
| line 4 | | * | * |
| line 5 | | * | * |
| line 6 | | * | |
| line 7 | | * | * |
| line 8 | | | * |
| line 9 | | * | |

Минималниот број на тестови за функцијата searchBookByTitle според Every Statement критериумот е 3.


## Тест случаи според критериумот Every branch
| | test 1 | test 2 | test 3 | test 4 |
|---|---|---|---|---|
| branch 1T | * | | | |
| branch 1F | | * | * | * |
| branch 2T | | | * | * |
| branch 2F | | * | | |
| branch 3T | | | * | |
| branch 3F | | | | * |

Минималниот број на тест случаи за borrowBook според Every Branch критериумот е 4.
