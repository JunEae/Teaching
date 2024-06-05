<script>
import api from "./api/api.js";

export default {
  data() {
    return {
      users: [],
      userAge: '',
      userName: '',
      Password: '',
      email: '',
      errorMessage: ''
    }
  },
  methods: {
    async signupUser() {
      const newUser = {
        userName: this.userName,
        userAge: this.userAge,
        email:this.email,
        password: this.Password,
      }
      try {
        const response = await api.post('/auth/signup', newUser);
        console.log('Успешно зарегистрирован:', newUser);
        window.location.href = "/log";
      } catch (error) {
        if (!error.response || error.response.status !== 401) {
          this.errorMessage = "Пожалуйста, измените имя пользователя";
        } else {
          this.errorMessage = "Ошибка авторизации! Проверьте логин и пароль";
        }
        console.error(error);
      }
    }
  }
  
}
</script>

<template>
  <div class="All">
    <header>
    </header>
    <div class="form-container">
      <div class="form">
        <div class="title">Bonjour!</div>
        <div class="subtitle">Давайте создадим ваш аккаунт</div>
        <div class="input-container ic1">
          <input id="userName" class="input" type="text" v-model="userName" placeholder=" " >
          <div class="cut"></div>
          <label for="Имя" class="placeholder">Имя</label>
        </div>
        <div class="input-container ic2">
          <input id="age" class="input" type="number" v-model="userAge" placeholder=" " >
          <div class="cut"></div>
          <label for="Возраст" class="placeholder">Возраст</label>
        </div>
        <div class="input-container ic2">
          <input id="email" class="input" type="text" v-model="email" placeholder=" " >
          <div class="cut cut-short"></div>
          <label for="email" class="placeholder">Email</label>
        </div>
        <div class="input-container ic2">
          <input id="password" class="input" type="text" v-model="Password" placeholder=" " >
          <div class="cut cut-short"></div>
          <label for="Пароль" class="placeholder">Пароль</label>
        </div>
        <button type="submit" class="submit" @click.prevent="signupUser"><span></span>
        <span></span>
        <span></span>
        <span></span>Зарегистрироваться</button>
        <div class="log_text">Уже есть аккаунт?</div>
        <div class="link"><a href="/Log">Войти в аккаунт</a></div>
      </div>
    </div>
    <footer></footer>
  </div>
  </template>
  
  <style scoped>
  @import url('https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap');
.All {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
  }
  
.form-container {
  display: flex;
  justify-content: center;
}
  
body {
  align-items: center;
  background-color: #000;
  display: flex;
  justify-content: center;
  height: 100vh;
}

.form {
  background-color: #15172b;
  border-radius: 20px;
  box-sizing: border-box;
  padding: 20px;
  width: 600px;
}

.title {
  color: #eee;
  font-family: sans-serif;
  font-size: 36px;
  font-weight: 600;
  margin-top: 30px;
  text-align: center;
}

.subtitle {
  color: #eee;
  font-family: sans-serif;
  font-size: 16px;
  font-weight: 600;
  margin-top: 10px;
  text-align: center;
}

.input-container {
  height: 50px;
  position: relative;
  width: 80%;
  margin: 0 auto;
}

.ic1 {
  margin-top: 40px;
}

.ic2 {
  margin-top: 30px;
}

.input {
  background-color: #303245;
  border-radius: 12px;
  border: 0;
  box-sizing: border-box;
  color: #eee;
  font-size: 18px;
  height: 100%;
  outline: 0;
  padding: 4px 20px 0;
  width: 100%;
}

.cut {
  background-color: #15172b;
  border-radius: 10px;
  height: 20px;
  left: 20px;
  position: absolute;
  top: -20px;
  transform: translateY(0);
  transition: transform 200ms;
  width: 60px;
}

.cut-short {
  width: 60px;
}

.input:focus ~ .cut,
.input:not(:placeholder-shown) ~ .cut {
  transform: translateY(8px);
}

.placeholder {
  color: #65657b;
  font-family: sans-serif;
  left: 20px;
  line-height: 14px;
  pointer-events: none;
  position: absolute;
  transform-origin: 0 50%;
  transition: transform 200ms, color 200ms;
  top: 20px;
}

.input:focus ~ .placeholder,
.input:not(:placeholder-shown) ~ .placeholder {
  transform: translateY(-30px) translateX(10px) scale(0.75);
}

.input:not(:placeholder-shown) ~ .placeholder {
  color: #808097;
}

.input:focus ~ .placeholder {
  color: #32e9f0;
}

*{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

.submit {
  position: relative;
  display: block;
  padding: 25px 30px;
  margin: 40px auto;
  color: #ffffff;
  text-decoration: none;
  text-transform: uppercase;
  transition: 0.5s;
  letter-spacing: 4px;
  overflow: hidden;
  background-color: #000;
}

.submit:hover {
  background: #03e9f4;
  color: #050801;
  box-shadow: 0 0 5px #03e9f4, 0 0 25px #03e9f4, 0 0 50px #03e9f4, 0 0 200px #03e9f4;
  -webkit-box-reflect: below 1px linear-gradient(transparent, rgba(0, 0, 0, 0.333));
  cursor: pointer;
}

.submit:nth-child(1) {
  filter: hue-rotate(270deg);
}

.submit:nth-child(2) {
  filter: hue-rotate(110deg);
}

.submit span {
  position: absolute;
  display: block;
}

.submit span:nth-child(1) {
  top: 0;
  left: 0;
  width: 100%;
  height: 2px;
  background: linear-gradient(90deg, transparent, #03e9f4);
  animation: animate1 1s linear infinite;
}

@keyframes animate1 {
  0% {
    left: -100%;
  }
  50%,
  100% {
    left: 100%;
  }
}

.submit span:nth-child(2) {
  top: -100%;
  right: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(180deg, transparent, #03e9f4);
  animation: animate2 1s linear infinite;
  animation-delay: 0.25s;
}
.log_text{
  text-align: center;
  color: #ffffff;
}
.link{
  text-align: center;
}

@keyframes animate2 {
  0% {
    top: -100%;
  }
  50%,
  100% {
    top: 100%;
  }
}

.submit span:nth-child(3) {
  bottom: 0;
  right: 0;
  width: 100%;
  height: 2px;
  background: linear-gradient(270deg, transparent, #03e9f4);
  animation: animate3 1s linear infinite;
  animation-delay: 0.5s;
}

@keyframes animate3 {
  0% {
    right: -100%;
  }
  50%,
  100% {
    right: 100%;
  }
}

.submit span:nth-child(4) {
  bottom: -100%;
  left: 0;
  width: 2px;
  height: 100%;
  background: linear-gradient(360deg, transparent, #03e9f4);
  animation: animate4 1s linear infinite;
  animation-delay: 0.75s;
}

@keyframes animate4 {
  0% {
    bottom: -100%;
  }
  50%,
  100% {
    bottom: 100%;
  }
}
a:visited{
  color: white;
}

</style>

