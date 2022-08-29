<#ftl encoding="utf-8">
<body xmlns="http://www.w3.org/1999/html">
    <ul>
        <#list elevegommettes as eg>
            <li>id elevegommettes :${eg.id} id gommettes :${eg.idGommette} id eleve :${eg.idEleve} id prof :${eg.idProf} raison :${eg.raison} date :${eg.date}</li>
        </#list>
    </ul>
    <form action="/eleves/${eleveid}/gommettes/update" method="post">
            Modifier une gommette pour cet élève:
            <input id="iidEleveGommetteUpdate" name="idEleveGommetteUpdate" placeholder="id de elevegommette ici" autocomplete="off">
            <input id="idGommetteUpdate" name="idGommetteUpdate" placeholder="id de gommette ici" autocomplete="off">
            <input id="raisonUpdate" name="raisonUpdate" placeholder="raison ici" autocomplete="off">
            <input id="dateUpdate" name="dateUpdate" placeholder="date ici" autocomplete="off">
            <input type="submit">
    </form>
    <form action="/eleves/${eleveid}/gommettes/add" method="post">
        Creer une gommette pour cet élève:
        <input id="idGommette" name="idGommette" placeholder="id de gommette ici" autocomplete="off">
        <input id="raison" name="raison" placeholder="raison ici" autocomplete="off">
        <input id="date" name="date" placeholder="date ici" autocomplete="off">
        <input type="submit">
    </form>
    <br>
    <a href="/eleves">Retourner à "eleves"<a/>
    <br>
    <br>
    <a href="/index">Retourner à la page d'accueil<a/>
</body>