# Catalog-Hibernate-Struts2

Este vorba despre o aplicatie web, care permite gestionarea cursurilor desfasurate de o unitate de invatamant. Se pot gestiona elevii, profesorii si cursurile, existand o interdependenta intre cele trei entitati. 

Programul este dezvoltat pe baza framework-urilor Hibernate si Struts 2. 

Intr-o baza de date de tip PostgreSQL sunt tinute trei tabele, fiecare corespunzatoare unei entitati (Profesor, Elev si Curs). Intre Profesor si Curs exista o legatura One To Many, iar intre Elev si Curs, Many To Many. Pentru fiecare elev este tinuta si evidenta notelor. Toate cele trei entitati au prevazute operatii CRUD (Create, Read, Update, Delete), pastrandu-se legaturile definite intre ele. Exista diverse posibilitati de afisare a informatiilor, astfel: toti profesorii unui elev, toti elevii unui profesor,  notele unui elev, toti elevii care participa la un curs, toate cursurile predate de un profesor.

Pagina logare – in functie de datele introduce se face directionarea automata catre sectiunea Elev sau Profesor.

In sectiunea Elev, este prezentata situatia notelor si sunt linkuri catre pagini care afiseaza toti profesorii elevului respectiv, precum si toate cursurile la care acesta participa.

Sectiunea Profesor da posibilitatea acordarii de note elevilor (profesorul logat nu poate acorda note decat propriilor elevi) si este prevazuta cu posibilitatea gestionarii tuturor entitatiilor (Curs, Elev, Profesor).

Gestioneaza cursuri – fiecare curs creat trebuie sa aiba un profesor titular, acesta se alege printr-un drop-down menu, care include toti profesorii inregistrati.

Gestioneaza elevi – cand se apasa Update, toate datele elevului respective apar in campurile care permit Adaugarea/Modificarea, pentru ca modificarea sa fie facuta mai usor.

Acorda note – un profesor poate acorda note doar eleviilor proprii. Nota acordata anterior poate fi modificata.
