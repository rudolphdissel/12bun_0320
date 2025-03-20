<template>

    <v-data-table
        :headers="headers"
        :items="goodsinformation"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GoodsinformationView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            goodsinformation : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/goodsinformations'))

            temp.data._embedded.goodsinformations.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.goodsinformation = temp.data._embedded.goodsinformations;
        },
        methods: {
        }
    }
</script>

