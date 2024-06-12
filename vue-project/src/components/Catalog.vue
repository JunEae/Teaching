<script >
export default{
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
    },
    page_catalog(){
        window.location.href="/catalog"
    },
    openModal(description) {
      const modal = document.getElementById('modal'); // Получаем модальное окно
      const modalContent = modal.querySelector('.modal-content'); // Получаем содержимое модального окна
      const modalDescription = modalContent.querySelector('p'); // Получаем элемент для отображения описания товара
      modalDescription.textContent = description; // Устанавливаем текст описания товара в модальном окне
      modal.style.display = "block"; // Отображаем модальное окно
    },
    closeModal() {
      const modal = document.getElementById('modal'); // Получаем модальное окно
      modal.style.display = "none"; // Скрываем модальное окно при нажатии на кнопку закрытия
    }
  }
};
</script>

<template>
  <head>
</head>
<body>
  <header>
    <h1>Каталог</h1>
  </header>
  <div class="catalog">
    <div class="item"  @click="openModal('Текст описания товара 1')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 1">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 2')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 2">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 3')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 3">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 4')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 4">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 5')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 5">

    </div>
    <div class="item"  @click="openModal('Текст описания товара 6')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 6">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 7')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 7">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 8')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 8">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 9')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 9">
    </div>
    <div class="item"  @click="openModal('Текст описания товара 10')">
      <img src="C:\Users\Инна\Desktop\teaching\vue-project\src\pictures\languages.jpg" alt="Изображение 10">
    </div>

    <div id="modal" class="modal">
    <div class="modal-content">
      <span class="close" @click="closeModal">&times;</span> <!-- Добавляем кнопку для закрытия модального окна -->
      <p></p>
    </div>
  </div>
  </div>
</body>

</template>

<style scoped>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

header {
  background-color: #f2f2f2;
  padding: 20px;
  text-align: center;
}

.catalog {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.item {
  margin: 10px;
}
.item img {
  width: 300px;
  height: 200px;
}


.modal {
  display: none;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.5);
}

.modal-content {
  background-color: #fefefe;
  margin: 15% auto;
  padding: 20px;
  border: 1px solid #888;
  width: 80%;
}

.close {
  color: #aaa;
  float: right;
  font-size: 28px;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}
</style>