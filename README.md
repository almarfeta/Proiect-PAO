# Proiect-PAO
Tema aleasa
------------
Am ales sa implementez o aplicatie care sa gestionez un lant de restaurante.

Clase
-----------
* Persoana -> din care deriva Angajat si Client
* Produs -> din care deriva Aliment si Bautura
* Restaurant
* Rezervare

Etapa 1
-------------
* am implementat clasele enumerate anterior
* am adaugat o metoda care incarca cateva date in aplicatie (simuland o baza de date)
* am adaugat un meniu care ofera posibilitatea logarii ca angajat (admin sau nu) sau client
* am adaugat metode pentru realizarea actiunilor Create si Read

Etapa 2
-------------
* am modificat structura proiectului, organizand clasele in: domain, persistance, service si view
* am incarcat date din fisiere CSV
* am implementat o clasa singleton pentru citire si afisare in fisier
* am adaugat un fisier audit care inregistreaza comenzile facute in aplicatie
* am adaugat metode pentru realizarea actiunilor Update si Delete

Etapa 3
-------------
* am modificat GenericRepository-ul pentru a realiza conexiunea cu baza de date
* am modificat toate celelalte Repository-uri pentr a realiza interogarile SQL
* am modificat Service-urile pentru a corespunde cu noile Repo-uri
