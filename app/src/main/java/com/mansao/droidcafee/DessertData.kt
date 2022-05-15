package com.mansao.droidcafee

object DessertData {
    private val dessertDescription = arrayOf(
        "Donuts are glazed and sprinkled with \n candy",
        "Ice cream sandwich have chocolate \n wafers and vanilla filing",
        "Froyo is premium self-serve frozen yogurt",
    )

    private val dessertName = arrayOf(
        "Donut",
        "Ice Cream Sandwich",
        "Froyo",
    )

    private val dessertImage = intArrayOf(
        R.drawable.donut_circle,
        R.drawable.icecream_circle,
        R.drawable.froyo_circle,
    )

    val listData: ArrayList<Desserts>
        get() {
            val list = arrayListOf<Desserts>()
            for (position in dessertDescription.indices) {
                val desserts = Desserts()
                desserts.name = dessertName[position]
                desserts.description = dessertDescription[position]
                desserts.image = dessertImage[position]
                list.add(desserts)
            }
            return list
        }

}