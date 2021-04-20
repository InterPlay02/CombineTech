package com.InterPlay.CombineTech.items;

import com.InterPlay.CombineTech.CombineTech;
import net.minecraft.item.Item;

// Esta classe extende as funcionalidade da classe chamada "Item" e adiciona suas próprias funcionalidades.
// A classe "Item" pede que os itens tenham apenas uma propriedade.
public class ItemTab extends Item {

    // Isso aqui está dizendo que os itens do meu mod devem ir para minha aba parsonalizada.
    public ItemTab() {
        super(new Item.Properties().tab(CombineTech.TAB));
    }

}
