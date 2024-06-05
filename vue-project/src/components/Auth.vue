<script >
export default{
  name:'Home',
  data(){
    return{
        title: "Почувствуй себя как дома в любой стране мира - изучай языки вместе с нами"
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
    <div class="First">
      <h1 class="title">TEXT {{ title }}</h1>
    </div>
  </header>
  <main>
    <div class="Reg_log">
      <div class="log">
      <button class="logBT"  @click="page_log()">Войти</button>
    </div>
    <div class ="reg">
      
    </div>
    </div>
    
  </main>
  <footer>
    
  </footer>
</div>
  
</template>
