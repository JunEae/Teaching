<script >
export default{
  data(){
    return{

    }
  },
  methods:{
  
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
      <div class="cat">
      <button class="catalog" href="/catalog">Каталог</button>
    </div>
  </div>
</header>

  
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

