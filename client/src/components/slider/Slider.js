import React, { useState } from 'react'
import { Carousel } from 'react-bootstrap';

import slide1 from './img/slide1.jpg';
import slide2 from './img/slide2.jpg';
import slide3 from './img/slide3.jpg';
import slide4 from './img/slide4.jpg';

function Slider() {
    const [slideGroup, setSlideGroup] = useState([slide1, slide2, slide3, slide4]);

    const slideTitle = 'Delightful Dish'
    const slideDesc = '지금 바로 레시피를 검색하고 따라 해보세요.'

    return (
        <Carousel style={{ display: 'flex', justifyContent: 'center' }}>

            <Carousel.Item>
                <div style={{ width: '100%', height: '40vh' }}>
                    <img
                        src={slide1}
                        alt="first food slide"
                        style={{ width: '100%', height: '100%' }}
                    />
                </div>
                <Carousel.Caption>
                    <h4>{slideTitle}</h4>
                    <p><i>{slideDesc}</i></p>
                </Carousel.Caption>
            </Carousel.Item>

            <Carousel.Item>
                <div style={{ width: '100%', height: '40vh' }}>
                    <img
                        src={slide2}
                        alt="second food slide"
                        style={{ width: '100%', height: '100%' }}
                    />
                </div>
                <Carousel.Caption>
                    <h4>{slideTitle}</h4>
                    <p><i>{slideDesc}</i></p>
                </Carousel.Caption>
            </Carousel.Item>

            <Carousel.Item>
                <div style={{ width: '100%', height: '40vh' }}>
                    <img
                        src={slide3}
                        alt="third food slide"
                        style={{ width: '100%', height: '100%' }}
                    />
                </div>
                <Carousel.Caption>
                    <h4>{slideTitle}</h4>
                    <p><i>{slideDesc}</i></p>
                </Carousel.Caption>
            </Carousel.Item>

            <Carousel.Item>
                <div style={{ width: '100%', height: '40vh' }}>
                    <img
                        src={slide4}
                        alt="fourth food slide"
                        style={{ width: '100%', height: '100%' }}
                    />
                </div>
                <Carousel.Caption>
                    <h4>{slideTitle}</h4>
                    <p><i>{slideDesc}</i></p>
                </Carousel.Caption>
            </Carousel.Item>



        </Carousel>
    )
}

export default Slider

