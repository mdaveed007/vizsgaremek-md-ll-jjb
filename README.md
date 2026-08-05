# Vizsgaremek - MMenza

Egy intelligens iskolai menzaalkalmazás, amely segít minimalizálni az ételpazarlást és modernizálja az ebédlemondás folyamatát.

## Csapattagok és Szerepkörök
*   **[Magyar Dávid]** - Projektmenedzser (PM) & Backend fejlesztő
*   **[Jónás János Balázs]** - Frontend fejlesztő
*   **[Lébenthal Levente]** - Adatbázis fejlesztő

---

## Tervezett Funkciók (Features)

A szoftver funkcióit a különböző felhasználói szerepkörök alapján strukturáltuk:

### Vendég / Diák funkciók (Kliens oldal)
*   **Regisztráció és Biztonságos Bejelentkezés:** Felhasználói fiók létrehozása érvényes adatokkal, jelszó-hasheléssel.
*   **Napi/Heti Menü megtekintése:** Reszponzív felület, ahol a diák látja az aktuális heti ételeket és azok allergén összetevőit.
*   **Étkezés Lemondása:** Egyetlen gombnyomással lemondható az adott napi ebéd az előre meghatározott időpontig (pl. reggel 8-ig).
*   **Ételértékelési Rendszer:** Csillagos (1-5) és szöveges értékelés leadása az elfogyasztott ételekről a minőségbiztosítás érdekében.

### Adminisztrátor / Konyhai vezető funkciók (Kezelői oldal)
*   **Interaktív Vezérlőpult (Dashboard):** Élő statisztika a napi szükséges adagszámokról, diagramok az ételpazarlás mértékéről.
*   **Menümenedzsment (CRUD):** Új ételek felvitele, módosítása, törlése az adatbázisból egy admin felületen keresztül.
*   **Felhasználók kezelése:** Diákok adatainak, jogosultságainak és étkezési státuszának adminisztrátori ellenőrzése.
*   **Kimutatások exportálása:** Napi adagszámok és alapanyag-szükségletek kinyerése PDF vagy Excel formátumban.

---

## Alkalmazott Technológiák (Tech Stack)
*   **Frontend:** HTML5, CSS3, JavaScript (React / Vue.js)
*   **Backend:** Node.js (Express) / C# (.NET Core) REST API
*   **Adatbázis:** MySQL / PostgreSQL
*   **Tesztelés:** Jest / Postman / Selenium
