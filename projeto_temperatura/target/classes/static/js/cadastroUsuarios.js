        const formulairo = document.querySelector("form");
        const Inome = document.querySelector(".nome");
        const Iemail = document.querySelector(".email");
        const Iusuario = document.querySelector(".user");
        const Isenha = document.querySelector(".senha");

        formulairo.addEventListener('submit', function(event) {
            event.preventDefault();
            cadastrar();
            limpar();
        });

        function cadastrar() {
            fetch("http://localhost:8080/api/cadastroUsuarios", { 
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                method: "POST",
                body: JSON.stringify({
                    nome: Inome.value,
                    email: Iemail.value,
                    usuario: Iusuario.value,
                    senha: Isenha.value
                })
            })
            .then(function (res) {
                if (res.ok) {
                    return res.json();
                } else {
                    throw new Error('Erro ao cadastrar usuário');
                }
            })
            .then(function (data) {
                console.log(data);
                alert("Usuário Cadastrado com sucesso");
            })
            .catch(function (err) {
                console.log(err);
                alert("Falha ao cadastrar usuário: " + err.message);
            });
        }
        

        function limpar(){
            Inome.value = "";
            Iusuario.value = "";            
            Isenha.value = "";
            Iemail.value = "";
        }
    
