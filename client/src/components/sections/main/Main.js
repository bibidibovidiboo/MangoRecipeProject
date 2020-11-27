import React from 'react'
import Slider from '../../slider/Slider';
import Refrigerator from '../../refrigerator/Refrigerator';
import { DndProvider } from 'react-dnd'
import { HTML5Backend } from 'react-dnd-html5-backend'
function Main() {
    return (
        <div>
            <Slider />
            여기는 Main 메인 페이지 입니다
            {/* 임시 텍스트 */}
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius perferendis laudantium praesentium repudiandae officiis cumque aspernatur? Sed explicabo voluptatibus, dicta molestias officia accusamus nam, mollitia accusantium nobis placeat asperiores deleniti porro reiciendis alias odit voluptatem doloremque deserunt veniam sapiente quis similique modi, neque voluptas? Facere, aperiam natus recusandae asperiores facilis maiores doloremque ipsa sit deserunt ratione quia qui alias impedit veniam error nihil neque at? Nemo harum, laborum mollitia eius suscipit recusandae magni veritatis asperiores inventore voluptates, sint sapiente porro, similique obcaecati voluptatum blanditiis eos natus nihil alias velit assumenda sunt ratione. Itaque totam facilis vitae iusto animi? Doloremque accusamus dignissimos eos molestias, corporis consectetur suscipit labore repellendus aut optio repudiandae excepturi magni commodi, debitis doloribus culpa libero, quo ratione dicta nesciunt mollitia asperiores quibusdam veritatis numquam. Ad fugiat aliquid ea repellendus nam, corrupti odit, excepturi maiores laudantium sapiente pariatur, nesciunt porro? Consectetur nihil illum amet enim beatae similique error eum praesentium sapiente porro, explicabo velit distinctio debitis molestiae mollitia iste repellat delectus perspiciatis tempore laboriosam eaque corrupti odio! Debitis quis, aliquid inventore dicta, cupiditate ea necessitatibus harum doloribus delectus itaque consequuntur voluptate, ab minus exercitationem minima tempora quaerat incidunt repellendus repellat modi quidem! Maiores iusto necessitatibus eius odio sunt!</p>
            <hr />
            {/* 냉장고 드래그엔 드롭 */}
            <DndProvider backend={HTML5Backend}>
                <Refrigerator />
            </DndProvider>
            {/* 임시 텍스트 */}
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius perferendis laudantium praesentium repudiandae officiis cumque aspernatur? Sed explicabo voluptatibus, dicta molestias officia accusamus nam, mollitia accusantium nobis placeat asperiores deleniti porro reiciendis alias odit voluptatem doloremque deserunt veniam sapiente quis similique modi, neque voluptas? Facere, aperiam natus recusandae asperiores facilis maiores doloremque ipsa sit deserunt ratione quia qui alias impedit veniam error nihil neque at? Nemo harum, laborum mollitia eius suscipit recusandae magni veritatis asperiores inventore voluptates, sint sapiente porro, similique obcaecati voluptatum blanditiis eos natus nihil alias velit assumenda sunt ratione. Itaque totam facilis vitae iusto animi? Doloremque accusamus dignissimos eos molestias, corporis consectetur suscipit labore repellendus aut optio repudiandae excepturi magni commodi, debitis doloribus culpa libero, quo ratione dicta nesciunt mollitia asperiores quibusdam veritatis numquam. Ad fugiat aliquid ea repellendus nam, corrupti odit, excepturi maiores laudantium sapiente pariatur, nesciunt porro? Consectetur nihil illum amet enim beatae similique error eum praesentium sapiente porro, explicabo velit distinctio debitis molestiae mollitia iste repellat delectus perspiciatis tempore laboriosam eaque corrupti odio! Debitis quis, aliquid inventore dicta, cupiditate ea necessitatibus harum doloribus delectus itaque consequuntur voluptate, ab minus exercitationem minima tempora quaerat incidunt repellendus repellat modi quidem! Maiores iusto necessitatibus eius odio sunt!</p>
        </div>
    )
}

export default Main
