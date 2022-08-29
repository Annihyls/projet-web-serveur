<#ftl encoding="utf-8">
<body xmlns="http://www.w3.org/1999/html">
    <form action="/login/create" method="post">
            Créer un compte :
            <input id="idProfCreate" name="idProfCreate" placeholder="id de professeur" autocomplete="off">
            <input id="usernameCreate" name="usernameCreate" placeholder="nom d'utilisateur" autocomplete="off">
            <input id="passwordCreate" name="passwordCreate" placeholder="mot de passe" autocomplete="off">
            <input type="submit">
    </form>
    <form action="/login/connect" method="post">
        Connexion :
         <input id="username" name="username" placeholder="identifiant" autocomplete="off">
         <input id="password" name="password" placeholder="mot de passe" autocomplete="off">
        <input type="submit">
    </form>
    <br>
    <a href="/index">Retourner à la page d'accueil<a/>
</body>