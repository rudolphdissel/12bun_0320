<template>

    <v-data-table
        :headers="headers"
        :items="myview"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'MyviewView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "customerId", value: "customerId" },
                { text: "productId", value: "productId" },
                { text: "qty", value: "qty" },
                { text: "address", value: "address" },
                { text: "orderStatus", value: "orderStatus" },
                { text: "deliveryStatus", value: "deliveryStatus" },
                { text: "price", value: "price" },
            ],
            myview : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/myviews'))

            temp.data._embedded.myviews.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.myview = temp.data._embedded.myviews;
        },
        methods: {
        }
    }
</script>

