<template>

</template>

<script>
export default {
    name: "EmptyPage",
    data(){
        return {
            tabName: '空白页',
        }
    },
    mounted() {
        this.$store.dispatch('base/setValue',{tabName: this.tabName})
    }
}
</script>

<style scoped>

</style>