<script >
export default{
  name:'Home',
  data(){
    return{

    }
  },
  methods:{
    page_reg(){
      window.location.href="/reg"
    },
    page_log(){
      window.location.href="/log"
    }
  }
}
</script>

<template>
<div class="All">
  <header>
    <div class="logo">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\logo.png">
    </div>
    <div class="textLogo">
      <h1 class="title">Расширь свои горизонты - выучи новый язык со Speech сегодня! </h1>
    </div>
    <div class="buttons">
      <div class="log">
      <button class="logButton"  @click="page_log()">Вход</button>
    </div>
    <div class ="reg">
      <button class="regButton" @click="page_reg()" href="/reg">Регистрация</button>
    </div>
  </div>
</header>
<div class="image-container">
  <label class="image-circle" for="modal-1">
    <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="">
  </label>
  <label class="image-circle" for="modal-2">
    <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\teachers.jpg" alt="">
  </label>
  <label class="image-circle" for="modal-3">
    <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\specialists.jpeg" alt="">
  </label>
  </div>
 
  <input class="modal-state" id="modal-1" type="checkbox" />
  <div class="modal">
  <label class="modal__bg" for="modal-1"></label>
  <div class="modal__inner">
    <label class="modal__close" for="modal-1"></label>
    <h2>1</h2>
    <p></p>
    <p>text</p>
  </div>
</div>

<input class="modal-state" id="modal-2" type="checkbox" />
  <div class="modal">
  <label class="modal__bg" for="modal-2"></label>
  <div class="modal__inner">
    <label class="modal__close" for="modal-2"></label>
    <h2>2</h2>
    <p></p>
    <p>text</p>
  </div>
</div>

<input class="modal-state" id="modal-3" type="checkbox" />
  <div class="modal">
  <label class="modal__bg" for="modal-3"></label>
  <div class="modal__inner">
    <label class="modal__close" for="modal-3"></label>
    <h2>3</h2>
    <p></p>
    <p>text</p>
  </div>
</div>

  
  <footer>
    <div class="imagesFooter">
    <div class="imgFooter1">
      <a href="https://t.me/J_uu_nee"><img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\iconTelegram.png" ></a>
    </div>
    <div class="imgFooter2">
      <a href="https://vk.com/juu_nee" ><img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\iconVk.png"></a>
    </div>
    <div class="imgFooter3">
      <a href="https://api.whatsapp.com/send?phone=79525683780"><img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\iconWhatsapp.png"></a>
    </div>
  </div>
  <div class="copyright">
    <p>© All rights reserved | Speech </p>
    </div>
  </footer>
</div>
  
</template>

<style scoped>

header {
  width: 100%;
  height: 10%;
  max-width: 1180px;
  margin: 0 auto;
  padding-left: 15px;
  padding-right: 15px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-sizing: border-box;
  position: fixed;
  top: 2%;
  left: 50%; /* Centering the header */
  transform: translateX(-50%);
  z-index: 100;
  background-color: rgb(13, 22, 41);
}

.logo {
  margin-right: auto; /* Pushes the logo to the left */
  margin-top: 2%; 
}

.logo img {
  height: 300px; /* Adjust the height of the logo as needed */
  width: auto; /* Maintain aspect ratio */
}

.textLogo {
      font-size: 10px;
      font-weight: bold;
      background: linear-gradient(to right, #9df0ff, #63e8ff, #2481fa,#7b18fc);
      background-clip: text;
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      margin: 0 auto; /* Center the textLogo horizontally */

    }
.buttons {
  list-style-type: none;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.buttons > *:not(:last-child) {
  margin-right: 10px;
}


.logButton, .regButton {
  background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8)),
    url(https://images.pexels.com/photos/2166927/pexels-photo-2166927.jpeg?cs=srgb&dl=animal-aquarium-aquatic-2166927.jpg&fm=jpg)
      no-repeat center center/cover;
  font-family: Arial, Helvetica, sans-serif;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 0,3rem;
  padding: 15px; /* Adjust the padding as needed */
  margin: 0 5px; /* Add margin between buttons */
  color: #f4f4f4;
  text-transform: uppercase;
  text-decoration: none;
  border: 1px solid rgb(146, 148, 248);
  position: relative;
  overflow: hidden;
}

.logButton:hover, .regButton:hover {
  box-shadow: 1px 1px 25px 10px rgba(146, 148, 248, 0.4);
  cursor: pointer;
}

.logButton:before, .regButton:before {
  content: "";
  position: absolute;
  top: 0;
  left: -100%;
  width: 100%;
  height: 100%;
  background: linear-gradient(
    120deg,
    transparent,
    rgba(146, 148, 248, 0.4),
    transparent
  );
  transition: all 650ms;
}

.logButton:hover:before, .regButton:hover:before {
  left: 100%;
}


.image-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  background-color: #f2f2f2;
}

.image-circle {
  background-color: rgb(13, 22, 41);
  width: 300px;
  height: 300px;
  border-radius: 50%;
  overflow: hidden;
  margin: 0 20px;
  cursor: pointer;
  position: relative;
  transition: all 0.3s ease-in-out;
}

.image-circle img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.modal {
  opacity: 0;
  visibility: hidden;
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  text-align: left;
  background: rgba(0,0,0, .9);
}

.modal__bg {
  position: absolute;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  cursor: pointer;
}

.modal-state {
  display: none;
}

.modal-state:checked + .modal {
  opacity: 1;
  visibility: visible;
  animation: fadein .5s;
  
}
@keyframes fadein {
	from {
		opacity:0;
	}
	to {
		opacity:1;
	}
}
.modal-state:checked + .modal .modal__inner {
  top: 0;
}

.modal__inner {
  position: absolute;
  top: -20%;
  right: 0;
  bottom: 0;
  left: 0;
  width: 50%;
  margin: auto;
  overflow: auto;
  background: #fff;
  border-radius: 5px;
  padding: 1em 2em;
  height: 50%;
}

.modal__close {
  position: absolute;
  right: 1em;
  top: 1em;
  width: 1.1em;
  height: 1.1em;
  cursor: pointer;
}

.modal__close:after,
.modal__close:before {
  content: '';
  position: absolute;
  width: 2px;
  height: 1.5em;
  background: #ccc;
  display: block;
  transform: rotate(45deg);
  left: 50%;
  margin: -3px 0 0 -1px;
  top: 0;
}

.modal__close:hover:after,
.modal__close:hover:before {
  background: #aaa;
}

.modal__close:before {
  transform: rotate(-45deg);
}

@media screen and (max-width: 768px) {
  
  .modal__inner {
    width: 90%;
    height: 90%;
    box-sizing: border-box;
  }
}

/* Анимация при наведении */
.image-circle:hover {
  transform: scale(1.1);
}


footer {
  position: fixed;
  bottom: 0;
  width: 100%;
  background-color: rgb(13, 22, 41);
}

.imagesFooter {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 3px;
}

.imagesFooter img {
  height: 70px;
  width: auto;
  margin-right: 10px;
}
.copyright{
  text-align: center;
}
</style>

